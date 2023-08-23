import { Container, Button } from './SortButton.styled';

const NavItem = [
  'Newest',
  'Active',
  'Bountied',
  'Unanswered',
  'Frequent',
  'Score',
];

function SortButton() {
  return (
    <Container>
      {NavItem.map((el) => (
        <Button key={el}>{String(el)}</Button>
      ))}
      {/* <MoreButton>More</MoreButton> */}
    </Container>
  );
}

export default SortButton;
