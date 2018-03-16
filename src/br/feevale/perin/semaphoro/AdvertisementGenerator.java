/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.perin.semaphoro;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Descrição da classe.
 */
public class AdvertisementGenerator {

    /**
     * Generates (query) a randomAd
     *
     * @return String
     */
    public static String randomAd() {
        try {
            System.out.println("randomAD");
            // Request to FreeMarket.
            Document doc = Jsoup.connect("https://www.mercadolivre.com.br/").get();
            // Recommendations section
            Element sectionRecommendations = doc.select("section.recommendations").first();
            // ADs
            StringBuilder sb = new StringBuilder(1024);
            sb.append(doc.title()).append("\n");
            sb.append("Confira as ofertas que estão bombando na sua cidade!!").append("\n\n\n");
            // Each element
            sectionRecommendations.select("div.slick-slide.slick-active").stream().forEach((e) -> {
                Element link = e.select("a[href]").first();
                sb.append(link.text()).append('\n').append(link.attr("href")).append("\n\n");
            });
            return sb.append("\n").toString();
        } catch (IOException e) {
            System.out.println("exception jsoup:");
            System.out.println(e);
            return "randomAd";
        }
    }

}
