package site.gutschi.solrexample.transport;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.gutschi.solrexample.input.CsvInputReader;
import site.gutschi.solrexample.model.Game;
import site.gutschi.solrexample.model.GameRepository;

import java.util.Collection;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/initialize")
public class InitializerController {
    private final GameRepository gameRepository;
    private final CsvInputReader csvInputReader;

    @GetMapping("")
    @Transactional
    public void init() {
        final var games = csvInputReader.readCsv();
        initDB(games);
        initIndex(games);
        log.info("Initialized " + games.size() + " games");
    }

    private void initDB(Collection<Game> games){
        try {
            gameRepository.truncate();
        } catch(Exception e) {
            log.warn("Could not truncate existing table, probably has not been created yet...", e);
        }
        gameRepository.saveAll(games);
    }

    public void initIndex(Collection<Game> games) {
    }

    /*
    public void initIndex(Collection<Game> games) {
        try (var solr = new org.apache.solr.client.solrj.impl.Http2SolrClient.Builder("http://localhost:8983/solr/games").build()){
            solr.deleteByQuery("*.*");
            games.forEach(game -> {
                try {
                    var document = convertToSolr(game);
                    solr.add(document);
                } catch (Exception e) {
                    log.warn("Could not index " + game, e);
                }
            });
            solr.commit();
        } catch (Exception e) {
            log.warn("Could not re-index ",e);
        }
    }


    private org.apache.solr.common.SolrInputDocument convertToSolr(Game game) {
        var document = new org.apache.solr.common.SolrInputDocument();
        document.addField("id", game.getId());
        document.addField("title", game.getTitle());
        if (game.getReleaseDate() != null) {
            final var dateStr = game.getReleaseDate()
                    .format(java.time.format.DateTimeFormatter.ISO_DATE)
                    + "T00:00:00Z";
            document.addField("releaseDate", dateStr);
        }
        game.getTeam().forEach(t -> document.addField("team", t));
        game.getGenres().forEach(g -> document.addField("genre", g));
        document.addField("summary", game.getSummary());
        game.getReviews().forEach(r -> document.addField("review", r));
        if (game.getRating() != null) {
            document.addField("rating", game.getRating());
        }
        document.addField("timesListed", game.getTimesListed());
        document.addField("wishlist", game.getWishlist());
        document.addField("backlogs", game.getBacklogs());
        document.addField("playing", game.getPlaying());
        document.addField("plays", game.getPlays());
        document.addField("numberOfReviews", game.getNumberOfReviews());
        return document;
    }
    */
}
