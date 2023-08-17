import {
  Content,
  Title,
  Text,
  ContentText,
  TextSmail,
  TextBlue,
} from './SignUpExplanation.styled';

import {
  faCircleQuestion,
  faThumbsUp,
  faTags,
  faTrophy,
} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

function SignUpExplanation() {
  return (
    <Content>
      <Title>Join the Stack Overflow community</Title>
      <div>
        <ContentText>
          <FontAwesomeIcon
            icon={faCircleQuestion}
            size="xl"
            style={{ color: '#0a95ff' }}
          />
          <Text>Get unstuck — ask a question</Text>
        </ContentText>
        <ContentText>
          <FontAwesomeIcon
            icon={faThumbsUp}
            size="xl"
            style={{ color: '#0a95ff' }}
          />
          <Text>Unlock new privileges like voting and commenting</Text>
        </ContentText>

        <ContentText>
          <FontAwesomeIcon
            icon={faTags}
            size="xl"
            style={{ color: '#0a95ff' }}
          />
          <Text>
            Save your favorite questions, answers, watch tags, and more
          </Text>
        </ContentText>

        <ContentText>
          <FontAwesomeIcon
            icon={faTrophy}
            size="xl"
            style={{ color: '#0a95ff' }}
          />
          <Text>Earn reputation and badges</Text>
        </ContentText>
      </div>
      <div>
        <TextSmail>
          Collaborate and share knowledge with a private group for FREE.
        </TextSmail>
        <TextBlue>
          Get Stack Overflow for Teams free for up to 50 users.
        </TextBlue>
      </div>
    </Content>
  );
}

export default SignUpExplanation;
