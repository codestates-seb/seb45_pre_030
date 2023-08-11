import {
  Container,
  Content,
  ContentContainer,
  MetaContainer,
  StatsContainer,
  StatsItem,
  Tag,
  TagContainer,
  Time,
  Title,
  UserCardContainer,
  UserImg,
  UserInfo,
} from './Mainbar.styled';

function Mainbar() {
  return (
    <Container>
      <StatsContainer>
        <StatsItem>0 votes</StatsItem>
        <StatsItem>0 answers</StatsItem>
        <StatsItem>2 views</StatsItem>
      </StatsContainer>
      <ContentContainer>
        <Title>Coursera React lab cant compile React code</Title>
        <Content>{`https://imanudin.net/2020/10/17/zimbra-tips-how-to-add-external-email-warning-message/ I have used this guide to set up my caution message but it doesn't seem to`}</Content>
        <MetaContainer>
          <TagContainer>
            <Tag type="button" value="sql" />
            <Tag type="button" value="javascript" />
            <Tag type="button" value="html" />
            <Tag type="button" value="css" />
          </TagContainer>
          <UserCardContainer>
            <UserImg src="logo192.png" />
            <UserInfo>
              <a href="/">hermit</a>
              <p>573</p>
            </UserInfo>
            <Time>asked 55 secs ago</Time>
          </UserCardContainer>
        </MetaContainer>
      </ContentContainer>
    </Container>
  );
}

export default Mainbar;
