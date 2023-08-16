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

const dummy = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

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
            <Total>{dummy.length} questions</Total>
            <FilterWrapper>
              <SortButton />
              <FilterButton />
            </FilterWrapper>
          </SubWrapper>
          <FilterOption />
        </SubContainer>
        {dummy.map((data) => (
          <Question key={data} />
        ))}
      </div>
      <div>
        <SideBar />
      </div>
    </Container>
  );
}

export default Questions;
