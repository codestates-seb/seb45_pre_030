package com.codestates.StackOverFlowClone.question.mock;

import com.codestates.StackOverFlowClone.question.dto.OnlyQuestionResponseDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.mapper.QuestionMapper;
import com.codestates.StackOverFlowClone.question.service.QuestionService;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper mapper;

    @Test
    void postQuestionTest() throws Exception {
        // given
        QuestionDto.Post post = new QuestionDto.Post("title1",1,"content1");

        given(mapper.questionPostDtoToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());

        Question mockQuestion = new Question();
        mockQuestion.setQuestionId(1L);
        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(mockQuestion);

        String content = gson.toJson(post);
        URI uri = UriComponentsBuilder.newInstance().path("/question").build().toUri();

        // when
        ResultActions actions =
                mockMvc.perform (
                        MockMvcRequestBuilders
                                .post(uri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location",is(startsWith("/question"))));

    }

    @Test
    void patchQuestionTest() throws Exception {

        // given

        Question curQuestion = new Question(1L,"title1",1L,"content1",0L,null,null,0L);

        QuestionDto.Patch patch = new QuestionDto.Patch();
        patch.setQuestionId(1L);
        patch.setTitle("title2");
        patch.setContent("content2");
        patch.setMemberId(1L);

        given(mapper.questionPatchDtoToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());

        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());

        OnlyQuestionResponseDto response = new OnlyQuestionResponseDto();
        response.setQuestionId(patch.getQuestionId());
        response.setTitle(patch.getTitle());
        response.setContent(patch.getContent());
        response.setMemberId(patch.getMemberId());

        given(mapper.questionToOnlyQuestionResponseDto (Mockito.any(Question.class))).willReturn(response);

        Gson gson = new Gson();
        String content = gson.toJson(patch);
        URI uri = UriComponentsBuilder.newInstance().path("/question/{questionId}").buildAndExpand(patch.getQuestionId()).toUri();


        // when
        ResultActions actions =
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch(uri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.title").value(patch.getTitle()))
                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()));

    }

    @Test
    void getQuestionTest() throws Exception {

        // given
        Question curQuestion = new Question(1L,"title1",1L,"content1",0L,null,null,0L);

        OnlyQuestionResponseDto onlyresponse = new OnlyQuestionResponseDto();
        onlyresponse.setQuestionId(curQuestion.getQuestionId());
        onlyresponse.setTitle(curQuestion.getTitle());
        onlyresponse.setContent(curQuestion.getContent());

        QuestionDto.Response response = new QuestionDto.Response(onlyresponse, null);

        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());

        given(mapper.questionToOnlyQuestionResponseDto(Mockito.any(Question.class))).willReturn(onlyresponse);

        given(mapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(response);

        URI uri = UriComponentsBuilder.newInstance().path("/question/{questionId}").buildAndExpand(curQuestion.getQuestionId()).toUri();

        // when
        ResultActions actions = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.question.title").value(curQuestion.getTitle()))
                .andExpect(jsonPath("$.data.question.content").value(curQuestion.getContent()));

    }

    @Test
    void getQuestionsTest() throws Exception {
        //given
        Question curQuestion1 = new Question(1L,"title1",1L,"content1",0L,null,null,0L);
        Question curQuestion2 = new Question(2L,"title2",2L,"content2",0L,null,null,0L);

        OnlyQuestionResponseDto onlyresponse1 = new OnlyQuestionResponseDto();
        onlyresponse1.setQuestionId(curQuestion1.getQuestionId());
        onlyresponse1.setTitle(curQuestion1.getTitle());
        onlyresponse1.setContent(curQuestion1.getContent());

        QuestionDto.Response response1 = new QuestionDto.Response(onlyresponse1, null);

        OnlyQuestionResponseDto onlyresponse2 = new OnlyQuestionResponseDto();
        onlyresponse2.setQuestionId(curQuestion2.getQuestionId());
        onlyresponse2.setTitle(curQuestion2.getTitle());
        onlyresponse2.setContent(curQuestion2.getContent());

        QuestionDto.Response response2 = new QuestionDto.Response(onlyresponse2, null);

        Page<Question> pageQuestions =
                new PageImpl<>(List.of(curQuestion1, curQuestion2),
                        PageRequest.of(0, 2, Sort.by("questionId").descending()), 2);

        List< OnlyQuestionResponseDto > responses = List.of(
                onlyresponse1, onlyresponse2
        );

        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(pageQuestions);

        given(mapper.questionsToOnlyQuestionResponseDtos(Mockito.anyList())).willReturn(responses);

        String page = "1";
        String size = "2";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        URI uri = UriComponentsBuilder.newInstance().path("/question").build().toUri();

        // when
        ResultActions actions = mockMvc.perform(
                get(uri)
                        .params(queryParams)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        MvcResult result = actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].title").value(curQuestion1.getTitle()))
                .andExpect(jsonPath("$.data[1].content").value(curQuestion2.getContent()))
                .andExpect(jsonPath("$.pageInfo.size").value(size))
                .andReturn();

    }

    @Test
    void deleteQuestionTest() throws Exception {
        // given
        Question curQuestion = new Question(1L,"title1",1L,"content1",0L,null,null,0L);

        doNothing().when(questionService).deleteQuestion(curQuestion.getQuestionId());

        // when
        ResultActions actions = mockMvc.perform(
                delete("/question/"+curQuestion.getQuestionId())
        );

        // then
        actions.andExpect(status().isNoContent());

    }

}
