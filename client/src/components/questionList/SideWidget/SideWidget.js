import { Container, Content, Title } from './SideWidget.styled';

function SideWidget() {
  return (
    <Container>
      <Title>The Overflow Blog</Title>
      <Content>Why everyone should be an AppSec specialist (Ep. 598)</Content>
      <Title>The Overflow Blog</Title>
      <Content>Moderation strike: Results of negotiations</Content>
      <Content>
        Our Design Vision for Stack Overflow and the Stack Exchange network
      </Content>
      <Content>
        Temporary policy: Generative AI (e.g., ChatGPT) is banned
      </Content>
      <Content>Preview of Search and Question-Asking Powered by GenAI</Content>
      <Content>
        Collections: A New Feature for Collectives on Stack Overflow
      </Content>
    </Container>
  );
}

export default SideWidget;
