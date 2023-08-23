import PropTypes from 'prop-types';
import { AnswerDiv, AnswerTextArea, AnswerButton } from './ASTextArea.styled';
import { useState, useRef } from 'react';

function ASText({ onCreate }) {
  const [answerText, setAnswerText] = useState({
    content: '',
  });

  const AnswerTextRef = useRef();

  const HandleChangeAnswer = (e) => {
    setAnswerText({
      ...answerText,
      [e.target.name]: e.target.value,
    });
  };

  const HandleAnswerSubmit = () => {
    if (answerText.content.length < 1) {
      alert('1글자 이상 적어주세요');
      AnswerTextRef.current.focus();
      return;
    }
    onCreate(answerText.content);
    alert('답변을 작성 하였습니다.');
    setAnswerText({
      content: '',
    });
  };

  return (
    <AnswerDiv>
      <AnswerDiv>
        <AnswerTextArea
          name="content"
          value={answerText.content}
          onChange={HandleChangeAnswer}
          ref={AnswerTextRef}
        />
      </AnswerDiv>
      <AnswerDiv>
        <AnswerButton onClick={HandleAnswerSubmit}>
          Post Your Answer
        </AnswerButton>
      </AnswerDiv>
    </AnswerDiv>
  );
}
ASText.propTypes = {
  onCreate: PropTypes.string.isRequired,
};

export default ASText;
