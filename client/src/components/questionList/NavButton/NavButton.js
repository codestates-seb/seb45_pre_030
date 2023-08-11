import { Container, Button, MoreButton } from './NavButton.styled';

const NavItem = [
  'Newest',
  'Active',
  'Bountied',
  'Unanswered',
  'Frequent',
  'Score',
];

function NavButton() {
  return (
    <Container>
      {NavItem.map((el) => (
        <Button key={el}>{String(el)}</Button>
      ))}
      <MoreButton>More</MoreButton>
    </Container>
  );
}

export default NavButton;
