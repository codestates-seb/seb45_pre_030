import Tag from '../../Tag/Tag';
import { Container, More, Text, Title, Wrapper } from './RelatedTags.styled';

const dummydata = [
  { tag: 'javascript', total: 2509122 },
  { tag: 'python', total: 2158701 },
  { tag: 'java', total: 1905278 },
  { tag: 'c#', total: 1600031 },
  { tag: 'php', total: 1461670 },
  { tag: 'android', total: 1409197 },
  { tag: 'html', total: 1179556 },
  { tag: 'jquery', total: 1037877 },
  { tag: 'c++', total: 798138 },
  { tag: 'css', total: 797585 },

  { tag: 'ios', total: 682987 },
  { tag: 'sql', total: 664497 },
  { tag: 'mysql', total: 661206 },
  { tag: 'r', total: 495704 },
  { tag: 'node.js', total: 466375 },
  { tag: 'reactjs', total: 465698 },
  { tag: 'arrays', total: 414695 },
  { tag: 'c', total: 398594 },
  { tag: 'asp.net', total: 373655 },
  { tag: 'json', total: 357744 },
  { tag: 'python-3.x', total: 340731 },
  { tag: 'ruby-on-rails', total: 337267 },
  { tag: '.net', total: 333450 },
  { tag: 'sql-server', total: 331645 },
  { tag: 'swift', total: 329706 },
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
