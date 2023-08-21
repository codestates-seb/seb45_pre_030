import styled from 'styled-components';

export const Container = styled.ul`
  display: flex;
  flex-direction: column;
  border-radius: 4px;
  overflow: hidden;
  border: 1px solid hsl(210, 8%, 85%);
  width: 100%;
  height: auto;
  margin-bottom: 16px;
`;

export const TitleWrapper = styled.div`
  display: flex;
  background-color: hsl(210, 8%, 97.5%);
  justify-content: space-between;
  padding: 15px 15px;
`;

export const Text = styled.p`
  line-height: 15px;

  &.collectives-member {
    font-size: 12px;
    margin-top: 3px;
  }
  &.collectives-content {
    font-size: 13px;
  }
`;

export const Hyper = styled.a`
  cursor: pointer;
  font-size: 11px;
  color: hsl(206, 100%, 40%);

  &.collectives-sub {
    font-size: 15px;
    color: hsl(210, 8%, 45%);
  }
`;

export const Content = styled.div`
  padding: 16px;
  border-top: 1px solid hsl(210, 8%, 85%);
`;

export const ContentWrapper = styled.div`
  display: flex;
  margin-bottom: 8px;
`;

export const Item = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
`;

export const Image = styled.img`
  width: 32px;
  height: 32px;
  margin-right: 12px;
`;

export const Button = styled.button`
  border: 1px solid hsl(206, 85%, 57.5%);
  border-radius: 6px;
  color: hsl(206, 100%, 40%);
  font-size: 12px;
  padding: 0.8em;

  &:hover {
    background-color: hsl(206, 100%, 97%);
  }
`;
