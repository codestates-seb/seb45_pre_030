import styled from 'styled-components';

export const Container = styled.div`
  cursor: pointer;
  display: flex;
  justify-content: center;
  width: auto;
  margin: 20px 0;
  gap: 4px;
`;

export const Page = styled.p`
  display: flex;
  border: 1px solid hsl(210, 8%, 85%);
  color: hsl(210, 8%, 25%);
  border-radius: 4px;
  font-size: 13px;
  line-height: calc(25 / 13);
  padding: 0 8px;

  &:hover {
    background-color: hsl(210, 8%, 75%);
  }

  &.currentPage {
    cursor: default;
    background-color: hsl(27, 90%, 55%);
    border-color: hsl(27, 90%, 55%);
    color: hsl(0, 0%, 100%);
  }
`;
