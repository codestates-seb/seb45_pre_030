import styled from 'styled-components';

export const Container = styled.ul`
  display: flex;
  flex-direction: column;
  border-radius: 4px;
  overflow: hidden;
  border: 1px solid hsl(47, 65%, 84%);
  width: 100%;
  height: auto;
  margin-bottom: 16px;
`;

export const Title = styled.li`
  display: flex;
  align-items: center;
  background-color: hsl(47, 83%, 91%);
  font-size: 12px;
  font-weight: bold;
  width: 100%;
  padding: 12px 15px;
  border-bottom: 1px solid hsl(47, 65%, 84%);

  &:not(:first-of-type) {
    border-top: 1px solid hsl(47, 65%, 84%);
  }
`;

export const Content = styled.li`
  display: flex;
  align-items: center;
  background-color: hsl(47, 87%, 94%);
  font-size: 12px;
  width: 100%;
  padding: 12px 15px;
`;

export const Icon = styled.div`
  display: flex;
  margin-right: 8px;

  &.sideWidget-message {
    color: hsl(206, 90%, 69.5%);
  }
`;

export const Hyper = styled.a`
  cursor: pointer;
  color: hsl(210, 8%, 25%);
`;
