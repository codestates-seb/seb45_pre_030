import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  align-items: center;
  background-color: hsl(205, 46%, 92%);
  border-radius: 4px;
  padding: 4px 4px 4px 5px;
  margin: 2px;

  &:hover {
    cursor: pointer;
    background-color: hsl(205, 53%, 88%);
  }
`;

export const Name = styled.p`
  display: flex;
  align-items: center;
  margin-right: 4px;
  color: hsl(205, 47%, 42%);
  font-size: 11px;
  white-space: nowrap;
`;

export const Button = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  color: hsl(205, 47%, 42%);
  border-radius: 4px;
  height: 16px;
  width: 16px;

  &:hover {
    background-color: hsl(205, 46%, 32%);
    color: hsl(205, 53%, 88%);
  }
`;
