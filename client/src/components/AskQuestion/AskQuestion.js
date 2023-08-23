import { QuestionContainer, Headline } from './AQ.styled';
import Manual from './AQManual';
import Title from './AQTitle';

import { useState, useRef } from 'react';

function AskQuestion() {
  // 질문 데이터
  const [data, setData] = useState([]);

  // 질문 생성시 id값 1씩 증가
  const dataId = useRef(0);

  // 질문 생성
  const onCreate = (title, problem) => {
    const date = new Date().getTime();
    const newItem = {
      title,
      problem,
      date,
      id: dataId.current,
    };
    dataId.current++;
    setData([newItem, ...data]);
  };

  return (
    <QuestionContainer>
      <Headline>Ask a public question</Headline>
      <Manual />
      <Title onCreate={onCreate} />
    </QuestionContainer>
  );
}

export default AskQuestion;
