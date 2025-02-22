select fh.flavor
from first_half fh
order by fh.total_order desc, fh.shipment_id asc;