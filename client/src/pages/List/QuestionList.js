import Mainbar from '../../components/questionList/Mainbar/Mainbar';
import AskButton from '../../components/questionList/AskButton/AskButton';
import {
  Container,
  FilterWrapper,
  SubContainer,
  SubWrapper,
  Title,
  TitleWrapper,
  Total,
} from './QuestionList.styled';
import SideBar from '../../components/questionList/SideBar/SideBar';
import NavButton from '../../components/questionList/NavButton/NavButton';
import FilterButton from '../../components/questionList/FilterButton/FilterButton';

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
        </SubContainer>
        <Mainbar />
        <Mainbar />
        <Mainbar />
        <Mainbar />
      </div>
      <SideBar />
    </Container>
  );
}

export default QuestionList;
