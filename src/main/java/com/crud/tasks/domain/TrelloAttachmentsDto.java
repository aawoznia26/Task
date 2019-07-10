package com.crud.tasks.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloAttachmentsDto {

    private TrelloTrelloDto trello;
}
