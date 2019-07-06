package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MappersTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto toDo = new TrelloListDto("1", "To Do", false);
        TrelloListDto done = new TrelloListDto("2", "Done", true);
        TrelloListDto inProgress = new TrelloListDto("3", "In Progress", false);

        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(toDo);
        lists.add(done);
        lists.add(inProgress);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "Test board 1", lists);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "Test board 2", lists);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);

        //When
        List<TrelloBoard> mappedBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        Assert.assertSame(mappedBoards.get(0).getClass(), TrelloBoard.class );
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList toDo = new TrelloList("1", "To Do", false);
        TrelloList done = new TrelloList("2", "Done", true);
        TrelloList inProgress = new TrelloList("3", "In Progress", false);

        List<TrelloList> lists = new ArrayList<>();
        lists.add(toDo);
        lists.add(done);
        lists.add(inProgress);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "Test board 1", lists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Test board 2", lists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);

        //When
        List<TrelloBoardDto> mappedBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assert.assertSame(mappedBoardsDto.get(0).getClass(), TrelloBoardDto.class );
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto toDo = new TrelloListDto("1", "To Do", false);
        TrelloListDto done = new TrelloListDto("2", "Done", true);
        TrelloListDto inProgress = new TrelloListDto("3", "In Progress", false);

        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(toDo);
        lists.add(done);
        lists.add(inProgress);

        //When
        List<TrelloList> mappedLists = trelloMapper.mapToList(lists);

        //Then
        Assert.assertSame(mappedLists.get(0).getClass(), TrelloList.class );
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList toDo = new TrelloList("1", "To Do", false);
        TrelloList done = new TrelloList("2", "Done", true);
        TrelloList inProgress = new TrelloList("3", "In Progress", false);

        List<TrelloList> lists = new ArrayList<>();
        lists.add(toDo);
        lists.add(done);
        lists.add(inProgress);

        //When
        List<TrelloListDto> mappedListsDto = trelloMapper.mapToListDto(lists);

        //Then
        Assert.assertSame(mappedListsDto.get(0).getClass(), TrelloListDto.class );
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card1", "card1", "1", "1");

        //When
        TrelloCardDto mappedCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertSame(mappedCardDto.getClass(), TrelloCardDto.class );
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card1", "card1", "1", "1");

        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertSame(mappedCard.getClass(), TrelloCard.class );
    }
}