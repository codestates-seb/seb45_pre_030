import CollectivesWidget from './CollectivesWidget/CollectivesWidget';
import RelatedTags from './RelatedTags/RelatedTags';
import SideWidget from './SideWidget/SideWidget';
import { Container } from './SideBar.styled';

function SideBar() {
  return (
    <Container>
      <SideWidget />
      <CollectivesWidget />
      <RelatedTags />
    </Container>
  );
}

export default SideBar;
