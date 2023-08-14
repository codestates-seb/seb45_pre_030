import { useSelector } from 'react-redux';
import {
  Button,
  Container,
  Input,
  Option,
  OptionWrapper,
  SubContainer,
  TagContainer,
  TagWrapper,
  Title,
  Wrapper,
} from './FilterOption.styled';
import FilterTag from '../FilterTag/FilterTag';

const FilterBy = ['No answers', 'No accepted answer', 'Has bounty'];
const SortedBy = [
  'Newest',
  'Recent activity',
  'Highest score',
  'Most frequent',
  'Bounty ending soon',
];
const TaggedWith = ['My watched tags', 'The following tags:'];

function FilterOption() {
  const isFilterOptionHidden = useSelector(
    (state) => state.isFilterOptionHidden,
  );

  return (
    <Container className={isFilterOptionHidden ? 'hide' : ''}>
      <SubContainer>
        <Wrapper className="filterBy-wrapper">
          <Title>Filter by</Title>
          {FilterBy.map((el) => (
            <OptionWrapper key={el}>
              <Input type="checkbox" />
              <Option>{el}</Option>
            </OptionWrapper>
          ))}
        </Wrapper>
        <Wrapper className="sortBy-wrapper">
          <Title>Sorted by</Title>
          {SortedBy.map((el) => (
            <OptionWrapper key={el}>
              <Input type="radio" name="sortedBy" />
              <Option>{el}</Option>
            </OptionWrapper>
          ))}
        </Wrapper>
        <Wrapper className="taggedWith-wrapper">
          <Title>Tagged with</Title>
          {TaggedWith.map((el) => (
            <OptionWrapper key={el}>
              <Input type="radio" name="taggedWith" />
              <Option>{el}</Option>
            </OptionWrapper>
          ))}
          <TagContainer>
            <TagWrapper>
              <FilterTag />
            </TagWrapper>
            <Input
              className="tag-editor"
              placeholder="e.g. javascript or python"
            />
          </TagContainer>
        </Wrapper>
      </SubContainer>
      <SubContainer>
        <Button className="apply_btn">Apply filter</Button>
        <Button className="cancel_btn">Cancel</Button>
      </SubContainer>
    </Container>
  );
}

export default FilterOption;
