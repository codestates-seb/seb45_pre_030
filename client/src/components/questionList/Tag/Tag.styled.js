import styled from 'styled-components';

export const Container = styled.li`
  display: flex;
  background-color: hsl(205, 46%, 92%);
  border-radius: 4px;
  padding: 4px 4px 7px 7px;

  &:hover {
    cursor: pointer;
    background-color: hsl(205, 53%, 88%);
  }
`;

export const P = styled.p`
  display: flex;
  align-items: center;
  margin-right: 4px;
  color: hsl(205, 47%, 42%);
  font-size: 12px;
`;
