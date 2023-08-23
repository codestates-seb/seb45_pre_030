import { Container, Content, Hyper, Icon, Title } from './SideWidget.styled';
import { faPen, faMessage, faPalette } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const dummydata = {
  blog: [`Why everyone should be an AppSec specialist (Ep. 598)`],
  message: [
    `Moderation strike: Results of negotiations`,
    `Our Design Vision for Stack Overflow and the Stack Exchange network`,
  ],
  news: [
    `Temporary policy: Generative AI (e.g., ChatGPT) is banned`,
    `Preview of Search and Question-Asking Powered by GenAI`,
    `Collections: A New Feature for Collectives on Stack Overflow`,
  ],
};

function SideWidget() {
  return (
    <Container>
      <Title>The Overflow Blog</Title>
      {dummydata.blog.map((data, idx) => (
        <Content key={idx}>
          <Icon>
            <FontAwesomeIcon icon={faPen} />
          </Icon>
          <Hyper>{data}</Hyper>
        </Content>
      ))}
      <Title>Featured on Meta</Title>
      {dummydata.message.map((data, idx) => (
        <Content key={idx}>
          <Icon className="sideWidget-message">
            <FontAwesomeIcon icon={faMessage} />
          </Icon>
          <Hyper>{data}</Hyper>
        </Content>
      ))}
      {dummydata.news.map((data, idx) => (
        <Content key={idx}>
          <Icon>
            <FontAwesomeIcon icon={faPalette} />
          </Icon>
          <Hyper>{data}</Hyper>
        </Content>
      ))}
    </Container>
  );
}

export default SideWidget;
