import AskButton from '../../components/questionList/AskButton/AskButton';
import {
  Container,
  FilterWrapper,
  Section,
  SectionContainer,
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
import Nav from '../../components/Nav/Nav';
import { Link } from 'react-router-dom';

const dummydata = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

function Questions() {
  return (
    <Container>
      <SectionContainer>
        <Section className="questions-nav-section">
          <Nav />
        </Section>
        <Section className="questions-main-section">
          <TitleWrapper>
            <Title>All Questions</Title>
            <Link to="/ask">
              <AskButton />
            </Link>
          </TitleWrapper>
          <SubContainer>
            <SubWrapper>
              <Total>{dummydata.length} questions</Total>
              <FilterWrapper>
                <SortButton />
                <FilterButton />
              </FilterWrapper>
            </SubWrapper>
            <FilterOption />
          </SubContainer>
          {dummydata.map((data) => (
            <Question key={data} />
          ))}
        </Section>
        <Section className="questions-side-section">
          <SideBar />
        </Section>
      </SectionContainer>
    </Container>
  );
}

export default Questions;
