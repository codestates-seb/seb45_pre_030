import AskButton from '../../components/questionList/AskButton/AskButton';
import {
  Container,
  FilterWrapper,
  SubContainer,
  SubWrapper,
  Title,
  TitleWrapper,
  Total,
} from './Questions.styled';
import SideBar from '../../components/questionList/SideBar/SideBar';
import NavButton from '../../components/questionList/NavButton/NavButton';
import FilterButton from '../../components/questionList/FilterButton/FilterButton';
import FilterOption from '../../components/questionList/FilterOption/FilterOption';
import Question from '../../components/questionList/Question/Question';

function QuestionList() {
  return (
    <Container>
      <div>
        <TitleWrapper>
          <Title>All Questions</Title>
          <AskButton />
        </TitleWrapper>
        <SubContainer>
          <SubWrapper>
            <Total>23,853,671 questions</Total>
            <FilterWrapper>
              <NavButton />
              <FilterButton />
            </FilterWrapper>
          </SubWrapper>
          <FilterOption />
        </SubContainer>
        <Question />
        <Question />
        <Question />
      </div>
      <SideBar />
    </Container>
  );
}

export default QuestionList;
