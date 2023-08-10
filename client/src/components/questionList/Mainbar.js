import {
  Container,
  Content,
  ContentContainer,
  MetaContainer,
  StatsContainer,
  StatsItem,
  TagContainer,
  Title,
} from './Mainbar.styled';

function Mainbar() {
  return (
    <Container>
      <StatsContainer>
        <StatsItem>votes</StatsItem>
        <StatsItem>answers</StatsItem>
        <StatsItem>views</StatsItem>
      </StatsContainer>
      <ContentContainer>
        <Title>Coursera React lab cant compile React code</Title>
        <Content>{`Coursera lab can't compile the react code, function App() { function handleClick() { let randomNum = Math.floor(Math.random() * 3) + 1;`}</Content>
        <MetaContainer>
          <TagContainer></TagContainer>
        </MetaContainer>
      </ContentContainer>
    </Container>
  );
}

export default Mainbar;
