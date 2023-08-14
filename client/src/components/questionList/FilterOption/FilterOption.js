import { useDispatch, useSelector } from 'react-redux';
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
import { addFilterTag } from '../../../redux/actions';
import FilterTag from './FilterTag/FilterTag';

const filterBy = ['No answers', 'No accepted answer', 'Has bounty'];
const sortedBy = [
  'Newest',
  'Recent activity',
  'Highest score',
  'Most frequent',
  'Bounty ending soon',
];

const taggedWith = ['My watched tags', 'The following tags:'];

function FilterOption() {
  const dispatch = useDispatch();
  const isFilterOptionHidden = useSelector(
    (state) => state.isFilterOptionHidden,
  );

  const filterTagList = useSelector((state) => state.filterTagList);

  const handleTagInputKeyPress = (e) => {
    // 스페이스바 금지
    if (e.key === ' ') {
      e.preventDefault();
    }

    if (e.key === 'Enter' || e.key === ' ') {
      const tag = e.target.value.trim();
      if (tag !== '' && !filterTagList.includes(tag)) {
        dispatch(addFilterTag(tag));
      }
      e.target.value = '';
      console.log(filterTagList);
    }
  };

  return (
    <Container className={isFilterOptionHidden ? 'hide' : ''}>
      <SubContainer>
        <Wrapper className="filterBy-wrapper">
          <Title>Filter by</Title>
          {filterBy.map((el) => (
            <OptionWrapper key={el}>
              <Input type="checkbox" />
              <Option>{el}</Option>
            </OptionWrapper>
          ))}
        </Wrapper>
        <Wrapper className="sortBy-wrapper">
          <Title>Sorted by</Title>
          {sortedBy.map((el) => (
            <OptionWrapper key={el}>
              <Input type="radio" name="sortedBy" />
              <Option>{el}</Option>
            </OptionWrapper>
          ))}
        </Wrapper>
        <Wrapper className="taggedWith-wrapper">
          <Title>Tagged with</Title>
          {taggedWith.map((el) => (
            <OptionWrapper key={el}>
              <Input type="radio" name="taggedWith" />
              <Option>{el}</Option>
            </OptionWrapper>
          ))}
          <TagContainer>
            <TagWrapper>
              {filterTagList.map((tag) => (
                <FilterTag key={tag} tag={tag} />
              ))}
              <Input
                className="tag-editor"
                placeholder={
                  filterTagList.length === 0 ? 'e.g. javascript or python' : ''
                }
                onKeyPress={handleTagInputKeyPress}
              />
            </TagWrapper>
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
