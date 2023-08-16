import { QuestionContainer, Headline } from './AQ.styled';
import Manual from './AQManual';
import Title from './AQTitle';

import { useState } from 'react';

function AskQuestion() {
  // 질문 데이터
  const [data, setData] = useState([]);
  // 질문 생성
  const onCreate = (title, problem) => {
    const date = new Date().getTime();
    const newItem = {
      title,
      problem,
      date,
    };
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
