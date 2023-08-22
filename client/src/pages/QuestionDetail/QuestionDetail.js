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
import { useState } from 'react';
import { Link } from 'react-router-dom';

const info = [
  { type: 'Asked', value: 'today' },
  { type: 'Modified', value: 'today' },
  { type: 'Viewed', value: '5 times' },
];

function QuestionDetail() {
  const [voteCount, setVoteCount] = useState(0);

  const handleVoteUp = () => {
    setVoteCount(voteCount + 1);
  };

  const handleVoteDown = () => {
    setVoteCount(voteCount - 1);
  };

  return (
    <Container>
      <SectionContainer>
        <Nav />
        <ContentContainer>
          <Wrapper>
            <Title>
              Application.commandbars force new menu to the end of the
              commandbar?
            </Title>
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
                  {`i have the below script which runs fine if i run it in it's
                  current state but in a newer version of excel we have
                  additional menus at the top of excel (Adobe and a few others)
                  is there any way to force the menu to place at the last place
                  possible on the right as currently (IMenuPos = 9 and iOffset =
                  0) it's not populating the menu automatically as there is a
                  menu item already in item 9. it also needs to ideally be the
                  end of the menu not just +1 as other people in here have
                  variable plugins in their excel which will then cause conflict
                  so it will vary heavily any advice on this would be great.`}
                </ContentText>
                <UserCardContainer>
                  <UserCard>
                    <Userimg src="/logo192.png" />
                    <UserInfoWrapper>
                      <Username>Ethan Bradberry</Username>
                      <UserDate>asked 1 hour ago</UserDate>
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
