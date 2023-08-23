import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  min-height: 600px;
`;

export const SectionContainer = styled.div`
  display: flex;
  justify-content: center;
  width: calc(100% - 164px);
`;

export const ContentContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 24px;
`;

export const InfoBox = styled.div`
  display: flex;
  margin: 0 16px 8px 0;
`;

export const Wrapper = styled.div`
  display: flex;
  width: 100%;
`;

export const InfoWrapper = styled.div`
  display: flex;
  width: 100%;
  border-bottom: 1px solid hsl(210, 8%, 90%);
  padding-bottom: 8px;
  margin-bottom: 16px;
`;

export const ContentWrapper = styled.div`
  display: flex;
`;

export const Title = styled.h1`
  font-size: 1.7rem;
  line-height: 1.35;
  color: hsl(210, 8%, 25%);
  margin: 0 12px 12px 0;
  width: 100%;
`;

export const Text = styled.p`
  white-space: nowrap;
  &.questionDetail-info-type {
    color: hsl(210, 8%, 45%);
    margin-right: 5px;
    font-size: 13px;
  }

  &.questionDetail-info-value {
    font-size: 13px;
  }
`;

export const VoteWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-right: 16px;
`;

export const VoteButton = styled.button`
  border: 1px solid hsl(210, 8%, 85%);
  border-radius: 100%;
  width: 42px;
  height: 42px;
  margin: 2px;
  font-size: 24px;
  color: hsl(210, 8%, 25%);
  padding: 0.8em;
`;

export const Vote = styled.p`
  margin: 2px;
  font-weight: 600;
  font-size: 1.2rem;
  color: hsl(210, 8%, 15%);
  padding: 4px 0;
`;

export const ContentTextWrapper = styled.div`
  padding-right: 16px;
  min-width: 500px;
  max-width: 655px;
`;

export const ContentText = styled.p`
  overflow-wrap: break-word;
  line-height: 1.5;
`;

export const UserCardContainer = styled.div`
  display: flex;
  justify-content: end;
  margin: 64px 0 16px 0;
`;

export const UserCard = styled.div`
  display: flex;
  align-items: center;
  width: 200px;
  background-color: hsl(205, 53%, 88%);
  border-radius: 4px;
  padding: 5px 6px 7px 7px;
`;

export const Userimg = styled.img`
  width: 32;
  height: 32px;
  background-color: hsl(0, 0%, 100%);
  border-radius: 4px;
  margin-right: 6px;
`;

export const UserInfoWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 100%;
`;

export const UserDate = styled.p`
  background-color: hsl(205, 53%, 88%);
  border-radius: 4px;
  font-size: 12px;
  color: hsl(210, 8%, 45%);
`;

export const Username = styled.p`
  color: hsl(206, 100%, 40%);
  font-size: 14px;
`;
