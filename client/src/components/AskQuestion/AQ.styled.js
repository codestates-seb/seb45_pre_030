import styled from 'styled-components';

export const QuestionContainer = styled.div`
  height: 1700px;
  width: 1250px;
  display: block;
  margin: 0 auto;
`;

export const DivH1 = styled.h1`
  font-size: 21px;
  margin-bottom: 5px;
`;

export const Headline = styled(DivH1)`
  font-weight: bolder;
  font-size: 27px;
  margin: 16px 0px;
`;

export const DivBox = styled.div`
  padding: 24px;
  border: 1px solid hsl(210, 8%, 85%);
  border-radius: 7px;
  margin-bottom: 16px;
  width: 850px;
`;
export const ManualBox = styled(DivBox)`
  background-color: hsl(206, 100%, 97%);
  border-color: skyblue;
`;

export const DivH2 = styled.h2`
  font-size: 15px;
  margin-bottom: 8px;
`;
export const TitleH2 = styled(DivH2)`
  font-weight: bold;
`;

export const DivH4 = styled.h4`
  font-size: 12px;
  font-weight: normal;
  margin-bottom: 5px;
`;

export const DivH5 = styled.h5`
  font-size: 13px;
  font-weight: bold;
  margin-bottom: 5px;
`;

export const Ul = styled.ul`
  list-style-type: disc;
`;

export const Li = styled.li`
  font-size: 13px;
  margin: 0px 0px 4px 30px;
`;

export const QuestionInput = styled.input`
  width: 800px;
  height: 33px;
  border-radius: 7px;
`;

export const QuestionTextArea = styled.textarea`
  width: 800px;
  height: 210px;
  border-radius: 7px;
  resize: vertical;
`;

export const QuestionButton = styled.button`
  background-color: skyblue;
  color: white;
  width: 50px;
  height: 37px;
  margin-top: 10px;
  border-radius: 7px;
`;
