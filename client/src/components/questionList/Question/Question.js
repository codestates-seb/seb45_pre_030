import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import Tag from '../Tag/Tag';
import {
  Container,
  Content,
  ContentContainer,
  MetaContainer,
  StatsContainer,
  StatsItem,
  TagContainer,
  Text,
  Title,
  UserCardContainer,
  UserImg,
  UserInfo,
} from './Question.styled';
import { DateForm } from '../../../common/func';

const dummydata = { tag: ['java', 'javascript', 'html', 'css'] };

function Question({ data }) {
  const dateForm = DateForm(data.createdAt);

  return (
    <Container>
      <StatsContainer>
        <StatsItem>0 votes</StatsItem>
        <StatsItem>{data.replyCount} answers</StatsItem>
        <StatsItem>{data.viewCount} views</StatsItem>
      </StatsContainer>
      <ContentContainer>
        <Link
          to={{
            pathname: `/questions/${data.questionId}`,
          }}
        >
          <Title>{data.title}</Title>
        </Link>
        <Content>{data.content}</Content>
        <MetaContainer>
          <TagContainer>
            {dummydata.tag.map((data) => (
              <Tag key={data} tag={data} />
            ))}
          </TagContainer>
          <UserCardContainer>
            <UserImg src="logo192.png" />
            <UserInfo>
              <Text className="question-username">{data.memberId}</Text>
            </UserInfo>
            <Text className="question-time">asked {dateForm}</Text>
          </UserCardContainer>
        </MetaContainer>
      </ContentContainer>
    </Container>
  );
}

Question.propTypes = {
  data: PropTypes.object.isRequired,
};

export default Question;
