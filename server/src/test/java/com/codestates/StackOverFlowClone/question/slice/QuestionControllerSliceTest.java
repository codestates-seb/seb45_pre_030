package com.codestates.StackOverFlowClone.question.slice;

import com.codestates.StackOverFlowClone.member.dto.MemberDto;
import com.codestates.StackOverFlowClone.question.dto.QuestionDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerSliceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    private ResultActions postResultActions;

    private QuestionDto.Post post;

    @BeforeEach
    void initPost() throws Exception {

        MemberDto.Post memberPost = new MemberDto.Post("user1@gmail.com","user1","user1","abc");

        String content0 = gson.toJson(memberPost);

        URI uri0 = UriComponentsBuilder.newInstance().path("/members").build().toUri();

        postResultActions =
                mockMvc.perform(
                        post(uri0)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content0)
                );


        post = new QuestionDto.Post("title1",1,"content1");

        String content = gson.toJson(post);

        URI uri = UriComponentsBuilder.newInstance().path("/question").build().toUri();

        postResultActions =
                mockMvc.perform(
                        post(uri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
    }

    @Test
    void postQuesetionTest() throws Exception {

        // given , when -> initPost()


        // then
        postResultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.question.title").value(post.getTitle()))
                .andExpect(jsonPath("$.question.content").value(post.getContent()))
                .andExpect(header().string("Location", is(startsWith("/question"))));

    }

    @Test
    void patchQuestionTest() throws Exception {

        // given -> initPost


        String location = postResultActions.andReturn().getResponse().getHeader("Location");

        QuestionDto.Patch patch = new QuestionDto.Patch();
        patch.setQuestionId(1L);
        patch.setTitle("title2");
        patch.setContent("content2");
        patch.setMemberId(1L);

        String patchContent = gson.toJson(patch);

        // when
        ResultActions actions =
                mockMvc.perform(
                        patch(location)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(patchContent)
                );

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.title").value(patch.getTitle()))
                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()));

    }

    @Test
    void getQuestionTest() throws Exception {

        // given -> initPost()

        String location = postResultActions.andReturn().getResponse().getHeader("Location");

        // when
        ResultActions actions =
                mockMvc.perform(
                        get(location)
                                .accept(MediaType.APPLICATION_JSON)
                );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.question.title").value(post.getTitle()))
                .andExpect(jsonPath("$.data.question.content").value(post.getContent()));

    }

    @Test
    void getQuestionsTest() throws Exception {
        // given -> initPost()

        String page = "1";
        String size = "2";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("page",page);
        params.add("size",size);

        URI getUri = UriComponentsBuilder.newInstance().path("/question").build().toUri();

        //when

        ResultActions actions =
                mockMvc.perform(
                        get(getUri)
                                .params(params)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        MvcResult result = actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].title").value(post.getTitle()))
                .andExpect(jsonPath("$.pageInfo.size").value(size))
                .andReturn();

    }

    @Test
    void deleteQuestionTest() throws Exception {

        // given -> initPost()

        String location = postResultActions.andReturn().getResponse().getHeader("Location");

        // when

        ResultActions actions =
                mockMvc.perform(
                        delete(location)
                );

        // then

        actions
                .andExpect(status().isNoContent());

    }

}
