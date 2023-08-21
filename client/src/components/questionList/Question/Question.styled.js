import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  justify-content: center;
  border-top: solid 1px hsl(210, 8%, 90%);
  padding: 16px;
`;

export const StatsContainer = styled.div`
  width: 108px;
  background-color: #fff;
  margin-right: 13px;
  margin-bottom: 4px;

  > p:not(:first-of-type) {
    color: hsl(200, 8%, 45%);
  }
`;

export const StatsItem = styled.p`
  display: flex;
  justify-content: flex-end;
  align-items: end;
  font-size: 14px;
  height: 17px;
  margin-bottom: 7px;
`;

export const ContentContainer = styled.div`
  width: 100%;
`;

export const Title = styled.h2`
  font-size: 18px;
  font-weight: 400;
  color: hsl(206, 100%, 52%);
  margin-bottom: 0.3846rem;

  &:hover {
    cursor: pointer;
    color: hsl(206, 100%, 52%);
  }
`;

export const Content = styled.p`
  display: flex;
  align-items: center;
  font-size: 14px;
  line-height: calc(17 / 13);
  margin-bottom: 8px;
`;

export const MetaContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
`;

export const TagContainer = styled.ul`
  display: flex;
  gap: 6px;
`;

export const UserCardContainer = styled.div`
  display: flex;
  align-items: center;
  gap: 4px;
  margin-left: auto;
  font-size: 12px;
`;

export const UserImg = styled.img`
  display: flex;
  gap: 4px;
  width: 16px;
  height: 16px;
`;

export const UserInfo = styled.div`
  display: flex;
  gap: 4px;
  margin-left: auto;

  > a {
    color: hsl(206, 100%, 40%);
  }

  > a:hover {
    color: hsl(206, 100%, 52%);
  }

  > p {
    color: hsl(210, 8%, 35%);
    font-weight: 700;
  }
`;

export const Time = styled.p`
  color: hsl(210, 8%, 45%);
`;
