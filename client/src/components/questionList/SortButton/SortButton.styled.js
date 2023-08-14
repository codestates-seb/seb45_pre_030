import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid hsl(210, 8%, 75%);
  border-radius: 6px;
  overflow: hidden;
  margin-right: 16px;
`;

export const Button = styled.button`
  padding: 0.8em;
  font-size: 12px;

  &:not(:first-of-type) {
    border-left: 1px solid hsl(210, 8%, 75%);
  }

  &:hover {
    background-color: hsl(210, 8%, 97.5%);
  }

  &:active {
    background-color: hsl(210, 8%, 90%);
  }
`;

export const MoreButton = styled.button`
  padding: 0.8em;
  font-size: 12px;
  border-left: 1px solid hsl(210, 8%, 75%);

  &:hover {
    background-color: hsl(210, 8%, 97.5%);
  }

  &:active {
    background-color: hsl(210, 8%, 90%);
  }
`;
