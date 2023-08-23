import Nav from '../../components/Nav/Nav';
import AskButton from '../../components/questionList/AskButton/AskButton';
import SideBar from '../../components/questionList/SideBar/SideBar';
import { faCaretUp, faCaretDown } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  InfoBox,
  Container,
  Text,
  Title,
  Wrapper,
  SectionContainer,
  ContentContainer,
  InfoWrapper,
  ContentWrapper,
  VoteWrapper,
  VoteButton,
  ContentText,
  ContentTextWrapper,
  Vote,
  UserCard,
  UserDate,
  UserInfoWrapper,
  Userimg,
  Username,
  UserCardContainer,
} from './QuestionDetail.styled';
import { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { fetchQuestion } from '../../api/api';
import { useDispatch, useSelector } from 'react-redux';
import { setFetchedQuestionData } from '../../redux/actions';
import { DateForm } from '../../common/func';

function QuestionDetail() {
  const questionId = useParams();
  const fetchedQuestionData = useSelector((state) => state.fetchedQuestionData);
  const dispatch = useDispatch();
  const [voteCount, setVoteCount] = useState(0);

  useEffect(() => {
    if (questionId.id)
      fetchQuestion(questionId.id)
        .then((question) => {
          dispatch(setFetchedQuestionData(question.data));
        })
        .catch((error) => {
          console.error(error);
        });
  }, [dispatch, questionId.id]);

  const handleVoteUp = () => {
    setVoteCount(voteCount + 1);
  };

  const handleVoteDown = () => {
    setVoteCount(voteCount - 1);
  };

  if (!fetchedQuestionData.question) {
    return <Container>Loading...</Container>; // 로딩 중 표시
  }

  const dateForm = DateForm(fetchedQuestionData.question.createdAt);

  const info = [
    { type: 'Asked', value: dateForm },
    { type: 'Modified', value: dateForm },
    { type: 'Viewed', value: fetchedQuestionData.question.viewCount },
  ];

  return (
    <Container>
      <SectionContainer>
        <Nav />
        <ContentContainer>
          <Wrapper>
            <Title>{fetchedQuestionData.question.title}</Title>
            <Link to="/ask">
              <AskButton />
            </Link>
          </Wrapper>
          <InfoWrapper>
            {info.map((el, idx) => (
              <InfoBox key={idx}>
                <Text className="questionDetail-info-type">{el.type}</Text>
                <Text className="questionDetail-info-value">{el.value}</Text>
              </InfoBox>
            ))}
          </InfoWrapper>
          <Container>
            <ContentWrapper>
              <VoteWrapper>
                <VoteButton onClick={handleVoteUp}>
                  <FontAwesomeIcon icon={faCaretUp} />
                </VoteButton>
                <Vote>{voteCount}</Vote>
                <VoteButton onClick={handleVoteDown}>
                  <FontAwesomeIcon icon={faCaretDown} />
                </VoteButton>
              </VoteWrapper>
              <ContentTextWrapper>
                <ContentText>
                  {fetchedQuestionData.question.content}
                </ContentText>
                <UserCardContainer>
                  <UserCard>
                    <Userimg src="/logo192.png" />
                    <UserInfoWrapper>
                      <Username>{fetchedQuestionData.question.name}</Username>
                      <UserDate>{dateForm}</UserDate>
                    </UserInfoWrapper>
                  </UserCard>
                </UserCardContainer>
              </ContentTextWrapper>
            </ContentWrapper>
            <SideBar />
          </Container>
        </ContentContainer>
      </SectionContainer>
    </Container>
  );
}

export default QuestionDetail;
