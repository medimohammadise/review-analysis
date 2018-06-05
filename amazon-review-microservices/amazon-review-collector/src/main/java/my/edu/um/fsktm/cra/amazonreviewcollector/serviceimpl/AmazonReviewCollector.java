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
	private List<my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review> reviews;
	private List<Integer> reviewRates;
	private List<String> reviewBodies;

	public AmazonReviewCollector() {
		reviews = new ArrayList<>();
		reviewRates = new ArrayList<>();
		// articles = new ArrayList<>();
	}

	// Find all URLs that start with "http://www.mkyong.com/page/" and add them to
	// the HashSet
	public List<Review> extractLatestReviews(String URL,String productID,LocalDate startDate ) {
        Elements paginationBar=null;
		Integer pageSize = 1;
		Optional<Document> document = Optional.empty();
		Pattern pattern = Pattern.compile("(\\d+)");
		try {
			document = Optional.of(Jsoup.connect(URL+"/"+productID).get());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		if (document.isPresent()) {

            pageSize = Integer.valueOf(document.get().select("div[id=cm_cr-pagination_bar]")
                .select("li[data-reftag=\"cm_cr_arp_d_paging_btm\"]").last().select("a").first().html());
            IntStream.range(1, pageSize).forEach(pageNo -> {
                Document pageDocument = null;
                try {
                    pageDocument = Jsoup.connect(URL + "/" + productID + "?pageNumber=" + pageNo).get();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Elements allReviewsInPage = pageDocument.select("div[data-hook=review]");

                allReviewsInPage.forEach(c -> {
                    String rating = "";

                    Matcher macther = pattern.matcher(c.select("div[id^=customer_review]")
                        .select("i[data-hook=review-star-rating]").first().getElementsByClass("a-icon-alt").html());
                    macther.find();

                    String reviewBody = c.select("div[id^=customer_review]").select("span[data-hook=review-body]").html();
                    String reviewTitle = c.select("div[id^=customer_review]").select("a[data-hook=review-title]").html();
                    String reviewAuthor = c.select("div[id^=customer_review]").select("a[data-hook=review-author]").html();
                    String reviewdate = c.select("div[id^=customer_review]").select("span[data-hook=review-date]").html();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");


                    LocalDate localReviewDate= LocalDate.parse(c.select("div[id^=customer_review]").select("span[data-hook=review-date]")
                        .html().substring(3), formatter);

                    if (localReviewDate.isAfter(startDate) ) {
                        reviews.add(new Review(
                            productID,
                            c.select("div[id^=customer_review]").attr("id").substring("customer_review-".length()),
                            c.select("div[id^=customer_review]").select("a[data-hook=review-title]").html(),
                            c.select("div[id^=customer_review]").select("a[data-hook=review-author]").html(),
                            c.select("div[id^=customer_review]").select("span[data-hook=review-body]").html(), localReviewDate)
                        );
                    }
                    else
                        return ;

                });

            });
        }
		return reviews;
	}

}
