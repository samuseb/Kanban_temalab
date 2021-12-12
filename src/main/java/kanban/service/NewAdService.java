package kanban.service;

import kanban.model.*;
import kanban.repository.BoardRepository;
import kanban.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewAdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void createNewAd(String name, String boardTitle){
        Board board = boardRepository.findFirstByTitle(boardTitle);

        Ad ad = new Ad(name, board);
    }
}
