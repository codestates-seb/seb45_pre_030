import CollectivesWidget from '../CollectivesWidget/CollectivesWidget';
import SideWidget from '../SideWidget/SideWidget';
import { Container } from './SideBar.styled';

function SideBar() {
  return (
    <Container>
      <SideWidget />
      <CollectivesWidget />
    </Container>
  );
}

export default SideBar;
