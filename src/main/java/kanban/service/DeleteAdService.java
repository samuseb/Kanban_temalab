package kanban.service;

import kanban.model.Ad;
import kanban.model.Board;
import kanban.repository.AdRepository;
import kanban.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeleteAdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void deleteAd(String adName){

        List<Ad> ads = adRepository.findByName(adName);

        for (Ad ad: ads){
            Board board = boardRepository.findFirstByTitle(ad.getBoard().getTitle());

            board.removeAd(ad);
            adRepository.delete(ad);
        }
    }
}
