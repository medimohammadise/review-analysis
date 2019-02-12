package my.edu.um.fsktm.cra.amazonreviewcollector.serviceimpl;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


@Service
public class AmazonReviewCollector {
	private  List<my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review> reviews;
	public AmazonReviewCollector() {

	}


	public   List<Review> extractLatestReviews(String URL,String productID,LocalDate startDate ) {
        reviews = new ArrayList<>();
        Elements allReviewsInPage=null;
        Integer pageNo = 1;

		Optional<Document> document = Optional.empty();
		Pattern pattern = Pattern.compile("(\\d+)");
		try {
			document = Optional.of(Jsoup.connect(URL+"/"+productID).ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .timeout(20000)
                    .followRedirects(true).get());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		if (document.isPresent()) {
            /*pageSize = Integer.valueOf(document.get().select("div[id~=cm_cr]")
                .select("li[class~=page-button]").last().
                            select("a").first().html());*/
            Optional<Document> pageDocument = null;
            do {


                try {
                    pageDocument = Optional.of(Jsoup.connect(URL + "/" + productID + "?pageNumber=" + pageNo).ignoreContentType(true)
                            .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                            .referrer("http://www.google.com")
                            .timeout(20000)
                            .followRedirects(true).get());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                allReviewsInPage = pageDocument.get().select("div[data-hook=review]");

                allReviewsInPage.forEach(c -> {
                    String rating = "";

                    Matcher macther = pattern.matcher(c.select("div[id^=customer_review]")
                        .select("i[data-hook=review-star-rating]").first().getElementsByClass("a-icon-alt").html());
                    macther.find();

                    String reviewBody = c.select("div[id^=customer_review]").select("span[data-hook=review-body]").html();
                    String reviewTitle = c.select("div[id^=customer_review]").select("a[data-hook=review-title]").html();
                    String reviewAuthor = c.select("div[id^=customer_review]").select("a[data-hook=review-author]").html();
                    String reviewdate = c.select("div[id^=customer_review]").select("span[data-hook=review-date]").html();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");


                    LocalDate localReviewDate= LocalDate.parse(reviewdate, formatter);

                    if (localReviewDate.isAfter(startDate) ) {
                        System.out.println("new review received");
                        reviews.add(new Review(
                            productID,
                            c.select("div[id^=customer_review]").attr("id").substring("customer_review-".length()),
                            c.select("div[id^=customer_review]").select("a[data-hook=review-title]").html(),
                            c.select("div[id^=customer_review]").select("a[data-hook=review-author]").html(),
                            c.select("div[id^=customer_review]").select("span[data-hook=review-body]").html(), localReviewDate,0)
                        );
                    }
                   // else
                   //     return ;

                });
                pageNo++;
                System.out.println("Next page =" +allReviewsInPage.size());
            } while(allReviewsInPage.size()!=0 && pageDocument.get().select("div[id~=cm_cr-pagination_bar]").select("li[class=a-disabled a-last]").isEmpty());
        }

		return reviews;
	}

}