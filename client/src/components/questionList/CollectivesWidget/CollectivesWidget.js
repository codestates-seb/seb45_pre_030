import {
  Container,
  Content,
  ContentWrapper,
  Hyper,
  Text,
  Title,
} from './CollectivesWidget.styled';

function CollectivesWidget() {
  return (
    <Container>
      <Title>
        <Text>Collectives</Text>
        <Hyper>see all</Hyper>
      </Title>
      <Content>
        <ContentWrapper></ContentWrapper>
        <ContentWrapper></ContentWrapper>
      </Content>
    </Container>
  );
}

export default CollectivesWidget;
