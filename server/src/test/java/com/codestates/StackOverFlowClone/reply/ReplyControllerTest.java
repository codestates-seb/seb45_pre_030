package com.codestates.StackOverFlowClone.reply;

import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.mapper.QuestionMapper;
import com.codestates.StackOverFlowClone.question.service.QuestionService;
import com.codestates.StackOverFlowClone.reply.dto.ReplyDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.reply.mapper.ReplyMapper;
import com.codestates.StackOverFlowClone.reply.service.ReplyService;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/*
@WebMvcTest
public class ReplyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReplyService replyService;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private ReplyMapper mapper;

    @MockBean
    private QuestionMapper questionMapper;

    @Autowired
    private Gson gson;

    private ReplyDto.Post post;
    private ResultActions postResultActions;
    private String location;
    private Reply mockResultReply;

    @BeforeEach
    public void init() throws Exception {
        this.post = new ReplyDto.Post(1, 1, "getTest");
        String request = gson.toJson(post);

        Question question = new Question();
        question.setQuestionId(1L);

        this.mockResultReply = new Reply();
        mockResultReply.setReplyId(1L);

        given(mapper.ReplyPostDtoToReply(Mockito.any(ReplyDto.Post.class))).willReturn(new Reply());
        given(replyService.createReply(Mockito.any(Reply.class))).willReturn(mockResultReply);

        URI uri = UriComponentsBuilder.newInstance().path("/question/1/reply").build().toUri();

        this.postResultActions = mockMvc.perform(
                post(uri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        this.location = this.postResultActions.andReturn().getResponse().getHeader("Location");
    }

    @Test
    public void postReplyTest() throws Exception {
        this.postResultActions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/question/1/reply/"))));
    }

    @Test
    public void patchReplyTest() throws Exception {
        ReplyDto.Patch patch = new ReplyDto.Patch(1, 0, 0, "patchTest");
        String request = gson.toJson(patch);

        ReplyResponseDto response = new ReplyResponseDto(1, 1, 0, "patchTest", LocalDateTime.now());


        given(mapper.ReplyPatchDtoToReply(Mockito.any(ReplyDto.Patch.class))).willReturn(new Reply());
        given(replyService.updateReply(Mockito.any(Reply.class))).willReturn(new Reply());
        given(mapper.ReplyToReplyResponseDto(Mockito.any(Reply.class))).willReturn(response);

        mockMvc.perform(
                        patch(this.location)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.content").value(response.getContent()));
    }

    @Test
    public void getReplyTest() throws Exception {
        ReplyResponseDto response = new ReplyResponseDto(1,1,1,"getTest",LocalDateTime.now());
        given(replyService.findReply(Mockito.anyLong())).willReturn(new Reply());
        given(mapper.ReplyToReplyResponseDto(Mockito.any(Reply.class))).willReturn(response);

        mockMvc.perform(
                get(this.location)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.questionId").value(this.post.getQuestionId()))
                .andExpect(jsonPath("$.data.memberId").value(this.post.getMemberId()))
                .andExpect(jsonPath("$.data.content").value(this.post.getContent()));
    }

}*/