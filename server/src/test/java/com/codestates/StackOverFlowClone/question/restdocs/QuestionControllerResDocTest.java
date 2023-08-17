package com.codestates.StackOverFlowClone.question.restdocs;

import com.codestates.StackOverFlowClone.question.controller.QuestionController;
import com.codestates.StackOverFlowClone.question.dto.OnlyQuestionResponseDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.mapper.QuestionMapper;
import com.codestates.StackOverFlowClone.question.service.QuestionService;

import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.codestates.StackOverFlowClone.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.StackOverFlowClone.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class QuestionControllerResDocTest {

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

        String content = gson.toJson(post);

        given(mapper.questionPostDtoToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());

        Question mockResultQuestion = new Question();
        mockResultQuestion.setQuestionId(1L);
        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(mockResultQuestion);

        ResultActions actions =
                mockMvc.perform(
                        post("/question")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/question/"))))
                .andDo(document(
                        "post-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("작성자"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용")
                                )
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header. 등록된 리소스의 URI")
                        )
                ));

    }

    @Test
    void patchQuesetionTest() throws Exception {
        long QuestionId = 1L;

        QuestionDto.Patch patch = new QuestionDto.Patch();
        patch.setQuestionId(QuestionId);
        patch.setTitle("title1");
        patch.setContent("content1");
        patch.setMemberId(1L);

        String content = gson.toJson(patch);

        OnlyQuestionResponseDto onlyQuestionResponseDto = new OnlyQuestionResponseDto(1L,"title1",1L,"content1", LocalDateTime.now(),0);

        given(mapper.questionPatchDtoToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());

        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());

        given(mapper.questionToOnlyQuestionResponseDto(Mockito.any(Question.class))).willReturn(onlyQuestionResponseDto);

        ResultActions actions =
                mockMvc.perform(
                        patch("/question/{question-id}",QuestionId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.questionId").value(patch.getQuestionId()))
                .andExpect(jsonPath("$.data.title").value(patch.getTitle()))
                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andDo(document("patch-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("질문번호")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문번호").ignored(),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("질문제목").optional(),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("질문내용").optional(),
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("질문작성자").optional()
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과데이터"),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문번호"),
                                        fieldWithPath("data.title").type(JsonFieldType.STRING).description("질문제목"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("질문내용"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("질문작성자"),
                                        fieldWithPath("data.createdAt").type(JsonFieldType.STRING).description("질문등록일시"),
                                        fieldWithPath("data.viewCount").type(JsonFieldType.NUMBER).description("질문조회수")

                                )
                        )
                ));

    }

    @Test
    void getQuestionTest() throws Exception {

        long questionId = 1L;
        Question question = new Question(1L,"title1",1L,"content1",0L,
                new ArrayList<Reply>(),LocalDateTime.now(),0 );

        OnlyQuestionResponseDto onlyQuestionResponseDto = new OnlyQuestionResponseDto(question.getMemberId(), question.getTitle(), question.getMemberId(), question.getContent(),
                question.getCreatedAt(), question.getViewCount());
        List<ReplyResponseDto> replies = new ArrayList<>();
        replies.add(new ReplyResponseDto(1L, 1L, 1L, "replycontent1",LocalDateTime.now()));

        QuestionDto.Response response = new QuestionDto.Response(onlyQuestionResponseDto, replies);

        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());
        given(mapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(response);

        URI uri = UriComponentsBuilder.newInstance().path("/question/{question-id}").buildAndExpand(questionId).toUri();

        ResultActions actions =
                mockMvc.perform(
                        RestDocumentationRequestBuilders
                                .get("/question/{question-id}",questionId)
                                .accept(MediaType.APPLICATION_JSON)
                );

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.question.title").value(question.getTitle()))
                .andExpect(jsonPath("$.data.question.content").value(question.getContent()))
                .andDo(document("get-question",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                List.of(
                                        parameterWithName("question-id").description("질문번호")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과데이터"),
                                        fieldWithPath("data.question").type(JsonFieldType.OBJECT).description("질문데이터"),
                                        fieldWithPath("data.question.questionId").type(JsonFieldType.NUMBER).description("질문번호"),
                                        fieldWithPath("data.question.title").type(JsonFieldType.STRING).description("질문제목"),
                                        fieldWithPath("data.question.memberId").type(JsonFieldType.NUMBER).description("질문작성자"),
                                        fieldWithPath("data.question.content").type(JsonFieldType.STRING).description("질문내용"),
                                        fieldWithPath("data.question.createdAt").type(JsonFieldType.STRING).description("질문작성일시"),
                                        fieldWithPath("data.question.viewCount").type(JsonFieldType.NUMBER).description("질문조회수"),
                                        fieldWithPath("data.replies").type(JsonFieldType.ARRAY).description("답변데이터"),
                                        fieldWithPath("data.replies[].replyId").type(JsonFieldType.NUMBER).description("답변번호"),
                                        fieldWithPath("data.replies[].questionId").type(JsonFieldType.NUMBER).description("답변의 질문번호"),
                                        fieldWithPath("data.replies[].memberId").type(JsonFieldType.NUMBER).description("답변작성자"),
                                        fieldWithPath("data.replies[].content").type(JsonFieldType.STRING).description("답변내용"),
                                        fieldWithPath("data.replies[].createdAt").type(JsonFieldType.STRING).description("답변작성일시")
                                )
                        )
                ));

    }

    @Test
    void getQuestionsTest() throws Exception {

        Question question1 = new Question(1L,"title1",1L,"content1",0L,
                new ArrayList<Reply>(),LocalDateTime.now(),0 );
        Question question2 = new Question(2L,"title2",2L,"content2",0L,
                new ArrayList<Reply>(),LocalDateTime.now(),0 );

        Page<Question> pageQuestions =
                new PageImpl<>(List.of(question1, question2),
                        PageRequest.of(1,2,
                                Sort.by("questionId").descending()),2);

        List<OnlyQuestionResponseDto> responses = List.of(
                new OnlyQuestionResponseDto(question1.getQuestionId(), question1.getTitle(), question1.getMemberId(),
                        question1.getContent(), question1.getCreatedAt(), question1.getViewCount()),
                new OnlyQuestionResponseDto(question2.getQuestionId(), question2.getTitle(), question2.getMemberId(),
                        question2.getContent(), question2.getCreatedAt(), question2.getViewCount())
        );

        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(pageQuestions);
        given(mapper.questionsToOnlyQuestionResponseDtos(Mockito.anyList())).willReturn(responses);

        String page = "1";
        String size = "2";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page",page);
        queryParams.add("size",size);

        URI uri = UriComponentsBuilder.newInstance().path("/question").build().toUri();

        ResultActions actions =
                mockMvc.perform(
                                get(uri).params(queryParams)
                                .accept(MediaType.APPLICATION_JSON)
                );

        ResultActions result = actions
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].title").value(question1.getTitle()))
                .andExpect(jsonPath("$.data[1].content").value(question2.getContent()))
                .andExpect(jsonPath("$.pageInfo.size").value(size))
                .andDo(document("get-questions",
                        preprocessRequest(),
                        preprocessResponse(),
                        requestParameters(
                                List.of(
                                        parameterWithName("page").description("페이지번호"),
                                        parameterWithName("size").description("페이지크기")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("질문리스트"),
                                        fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문번호"),
                                        fieldWithPath("data[].title").type(JsonFieldType.STRING).description("질문제목"),
                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("질문작성자"),
                                        fieldWithPath("data[].content").type(JsonFieldType.STRING).description("질문내용"),
                                        fieldWithPath("data[].createdAt").type(JsonFieldType.STRING).description("질문작성일시"),
                                        fieldWithPath("data[].viewCount").type(JsonFieldType.NUMBER).description("질문조회수"),
                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지번호"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지당 질문 개수"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("총 질문 개수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지 개수")
                                )
                        )
                ));

    }

    @Test
    void deleteQuestionTest() throws Exception {
        long questionId = 1L;

        doNothing().when(questionService).deleteQuestion(Mockito.anyLong());

        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.delete("/question/{question-id}",questionId)
        );

        ResultActions result =
                actions.andExpect(status().isNoContent())
                        .andDo(document("delete-question",
                                preprocessRequest(),
                                preprocessResponse(),
                                pathParameters(
                                        parameterWithName("question-id").description("질문번호")
                                )
                                ));
    }


}
