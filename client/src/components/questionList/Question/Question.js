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

const dummydata = { tag: ['java', 'javascript', 'html', 'css'] };

function formatDate(createdAt) {
  const dateObj = new Date(createdAt);
  const year = dateObj.getFullYear();
  const month = String(dateObj.getMonth() + 1).padStart(2, '0');
  const day = String(dateObj.getDate()).padStart(2, '0');
  const hours = String(dateObj.getHours()).padStart(2, '0');
  const minutes = String(dateObj.getMinutes()).padStart(2, '0');
  return `${year}/${month}/${day} ${hours}:${minutes}`;
}

function Question({ data }) {
  const formattedDate = formatDate(data.createdAt);

  return (
    <Container>
      <StatsContainer>
        <StatsItem>0 votes</StatsItem>
        <StatsItem>0 answers</StatsItem>
        <StatsItem>{data.viewCount} views</StatsItem>
      </StatsContainer>
      <ContentContainer>
        <Link
          to={{
            pathname: `/questions/${data.questionId}`,
            state: { questionData: data },
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
              <Text className="question-award">0</Text>
            </UserInfo>
            <Text className="question-time">asked {formattedDate}</Text>
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
