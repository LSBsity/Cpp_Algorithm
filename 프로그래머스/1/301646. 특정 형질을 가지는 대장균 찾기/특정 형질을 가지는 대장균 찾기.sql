select count(*) as count
from ecoli_data ed
where 
  (ed.genotype & 1 or
  ed.genotype & 4) and
  ed.genotype & 2 = 0