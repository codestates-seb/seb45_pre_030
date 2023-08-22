import Tag from '../../Tag/Tag';
import { Container, More, Text, Title, Wrapper } from './RelatedTags.styled';

const dummydata = [
  { tag: 'javascript', total: 0 },
  { tag: 'python', total: 0 },
  { tag: 'java', total: 0 },
  { tag: 'c#', total: 0 },
  { tag: 'php', total: 0 },
  { tag: 'android', total: 0 },
  { tag: 'html', total: 0 },
  { tag: 'jquery', total: 0 },
  { tag: 'c++', total: 0 },
  { tag: 'css', total: 0 },

  { tag: 'ios', total: 0 },
  { tag: 'sql', total: 0 },
  { tag: 'mysql', total: 0 },
  { tag: 'r', total: 0 },
  { tag: 'node.js', total: 0 },
  { tag: 'reactjs', total: 0 },
  { tag: 'arrays', total: 0 },
  { tag: 'c', total: 0 },
  { tag: 'asp.net', total: 0 },
  { tag: 'json', total: 0 },
  { tag: 'python-3.x', total: 0 },
  { tag: 'ruby-on-rails', total: 0 },
  { tag: '.net', total: 0 },
  { tag: 'sql-server', total: 0 },
  { tag: 'swift', total: 0 },
];

function RelatedTags() {
  return (
    <Container>
      <Title>Related Tags</Title>
      {dummydata.map(
        (data, idx) =>
          idx < 10 && (
            <Wrapper key={data.tag}>
              <Tag tag={data.tag} />
              <Text>× {data.total}</Text>
            </Wrapper>
          ),
      )}
      <More>more related tags</More>
    </Container>
  );
}

export default RelatedTags;
