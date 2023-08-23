import { AnswerContainer, AnswerH2 } from './Answer.styled';
import ASList from './ASList/ASList';
import ASText from './ASTextArea/ASTextArea';
import { useState, useRef } from 'react';

function Answer() {
  const [answer, setAnswer] = useState([]);

  const answerId = useRef(0);

  const onCreate = (content) => {
    const date = new Date().toLocaleString();
    const newItem = {
      content,
      date,
      id: answerId.current,
    };
    answerId.current++;
    setAnswer([newItem, ...answer]);
  };

  const onDelete = (targetId) => {
    const newAnswer = answer.filter((el) => el.id !== targetId);
    setAnswer(newAnswer);
  };

  const onEdit = (targetId, newContent) => {
    setAnswer(
      answer.map((el) =>
        el.id === targetId ? { ...el, content: newContent } : el,
      ),
    );
  };

  return (
    <AnswerContainer>
      <ASList answerlist={answer} onDelete={onDelete} onEdit={onEdit} />
      <AnswerH2>Your Answer</AnswerH2>
      <ASText onCreate={onCreate} />
    </AnswerContainer>
  );
}

export default Answer;
