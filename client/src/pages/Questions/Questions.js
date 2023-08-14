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
import FilterButton from '../../components/questionList/FilterButton/FilterButton';
import FilterOption from '../../components/questionList/FilterOption/FilterOption';
import Question from '../../components/questionList/Question/Question';
import SortButton from '../../components/questionList/SortButton/SortButton';

function Questions() {
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
              <SortButton />
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

export default Questions;
