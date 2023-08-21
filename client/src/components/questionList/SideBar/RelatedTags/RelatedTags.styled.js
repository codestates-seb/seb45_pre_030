import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
`;

export const Title = styled.h2`
  font-size: 1.1rem;
  color: hsl(210, 8%, 25%);
  margin-bottom: 1em;
`;

export const Wrapper = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 0.5em;
`;

export const Text = styled.p`
  font-size: 11px;
  color: hsl(210, 8%, 45%);
  margin-left: 4px;
`;

export const More = styled.a`
  cursor: pointer;
  font-size: 12px;
  color: hsl(206, 100%, 40%);
  margin: 5px 0;
`;
