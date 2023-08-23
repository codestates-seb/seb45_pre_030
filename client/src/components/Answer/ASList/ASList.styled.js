import styled from 'styled-components';

export const AnswerH2 = styled.h2`
  font-size: 19px;
  font-weight: bolder;
  margin-bottom: 10px;
`;

export const ListContainer = styled.div``;

export const ListBox = styled.div``;

export const AnswerH4 = styled.h4`
  margin-left: 10px;
  font-size: 15px;
`;

export const Answer = styled.div`
  width: 650px;
  border: 1px solid gray;
  margin-bottom: 10px;
  border-radius: 7px;
`;

export const ASTextBox = styled.div`
  /* width: 600px;
  height: 200px;
  overflow: auto; */
  padding: 5px;
`;

export const AnswerBox = styled.div`
  margin-top: 10px;
  padding: 5px;
`;
export const ASBox = styled(AnswerBox)`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

export const ASButtonBox = styled.div`
  padding: 10px;
  display: flex;
  width: 200px;
`;
export const ASDateBox = styled(ASButtonBox)`
  margin-left: 30px;
`;

export const ASTextArea = styled.textarea`
  height: 200px;
  width: 600px;
  border-radius: 7px;
  resize: vertical;
  margin-top: 10px;
`;

export const ASButton = styled.button`
  margin-right: 20px;
  border: 1px solid gray;
  padding: 5px;
`;
