import PropTypes from 'prop-types';
import { useState, useRef } from 'react';
import {
  DivBox,
  QuestionInput,
  TitleH2,
  DivH4,
  QuestionButton,
  QuestionTextArea,
} from './AQ.styled';

function Title({ onCreate }) {
  // 질문 작성칸 상태
  const [state, setState] = useState({
    title: '',
    content: '',
  });

  const contentUseRef = useRef();

  // text입력할 때 마다 작성칸 상태 변경
  const HandleChangeState = (e) => {
    setState({
      ...state,
      [e.target.name]: e.target.value,
    });
  };

  // 버튼 누르면 저장
  const HandleSubmit = () => {
    if (state.content.length < 20) {
      alert('20글자 이상 작성해 주세요.');
      contentUseRef.current.focus();
      return;
    }
    onCreate(state.title, state.content);
    alert('작성 완료 하였습니다.');
    setState({
      title: '',
      content: '',
    });
  };

  return (
    <DivBox>
      <TitleH2>Title</TitleH2>
      <DivH4>
        Be specific and imagine you’re asking a question to another person.
      </DivH4>
      <QuestionInput
        placeholder="e.g. ls there an R function for finding the index of an element in a vector"
        name="title"
        value={state.title}
        onChange={HandleChangeState}
      ></QuestionInput>
      <TitleH2>What are the details of your problem?</TitleH2>
      <DivH4>
        Introduce the problem and expand on what you put in the title. Minimum
        20 characters.
      </DivH4>
      <QuestionTextArea
        name="content"
        value={state.content}
        onChange={HandleChangeState}
        ref={contentUseRef}
      ></QuestionTextArea>
      <QuestionButton onClick={HandleSubmit}>Next</QuestionButton>
    </DivBox>
  );
}

Title.propTypes = {
  onCreate: PropTypes.string.isRequired,
};

export default Title;
