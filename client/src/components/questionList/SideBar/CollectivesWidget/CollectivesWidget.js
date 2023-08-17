import {
  Button,
  Container,
  Content,
  ContentWrapper,
  Hyper,
  Image,
  Item,
  Text,
  TitleWrapper,
} from './CollectivesWidget.styled';

const dummydata = [
  {
    img: 'logo192.png',
    sub: 'AWS',
    member: '16k',
    content: `Amazon Web Services (AWS) is the world’s most comprehensive and
    broadly adopted`,
  },
  {
    img: 'logo192.png',
    sub: 'Microsoft Azure',
    member: '11k',
    content: `On-premises, hybrid, multicloud, or at the edge—build on your terms with best-in`,
  },
  {
    img: 'logo192.png',
    sub: 'PHP',
    member: '2k',
    content: `A collective where developers working with PHP can learn and connect about the open`,
  },
];

function CollectivesWidget() {
  return (
    <Container>
      <TitleWrapper>
        <Text>Collectives</Text>
        <Hyper>see all</Hyper>
      </TitleWrapper>
      {dummydata.map((data, idx) => (
        <Content key={idx}>
          <ContentWrapper>
            <Image src={data.img} />
            <Item>
              <Hyper className="collectives-sub">{data.sub}</Hyper>
              <Text className="collectives-member">{data.member} Members</Text>
            </Item>
            <Button>Join</Button>
          </ContentWrapper>
          <ContentWrapper>
            <Text className="collectives-content">{data.content}</Text>
          </ContentWrapper>
        </Content>
      ))}
    </Container>
  );
}

export default CollectivesWidget;
